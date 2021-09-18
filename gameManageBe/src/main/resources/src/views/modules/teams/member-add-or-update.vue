<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="memberName">
      <el-input v-model="dataForm.memberName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="memberInfo">
      <el-input v-model="dataForm.memberInfo" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="memberSupport">
      <el-input v-model="dataForm.memberSupport" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="memberTeam">
      <el-input v-model="dataForm.memberTeam" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="memberIcon">
      <el-input v-model="dataForm.memberIcon" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          memberId: 0,
          memberName: '',
          memberInfo: '',
          memberSupport: '',
          memberTeam: '',
          memberIcon: ''
        },
        dataRule: {
          memberName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          memberInfo: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          memberSupport: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          memberTeam: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          memberIcon: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.memberId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.memberId) {
            this.$http({
              url: this.$http.adornUrl(`/teams/member/info/${this.dataForm.memberId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.memberName = data.member.memberName
                this.dataForm.memberInfo = data.member.memberInfo
                this.dataForm.memberSupport = data.member.memberSupport
                this.dataForm.memberTeam = data.member.memberTeam
                this.dataForm.memberIcon = data.member.memberIcon
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/teams/member/${!this.dataForm.memberId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'memberId': this.dataForm.memberId || undefined,
                'memberName': this.dataForm.memberName,
                'memberInfo': this.dataForm.memberInfo,
                'memberSupport': this.dataForm.memberSupport,
                'memberTeam': this.dataForm.memberTeam,
                'memberIcon': this.dataForm.memberIcon
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
