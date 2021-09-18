<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="teamName">
      <el-input v-model="dataForm.teamName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="teamIcon">
      <el-input v-model="dataForm.teamIcon" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="teamSupport">
      <el-input v-model="dataForm.teamSupport" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="teamInfo">
      <el-input v-model="dataForm.teamInfo" placeholder=""></el-input>
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
          teamId: 0,
          teamName: '',
          teamIcon: '',
          teamSupport: '',
          teamInfo: ''
        },
        dataRule: {
          teamName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          teamIcon: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          teamSupport: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          teamInfo: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.teamId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.teamId) {
            this.$http({
              url: this.$http.adornUrl(`/teams/team/info/${this.dataForm.teamId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.teamName = data.team.teamName
                this.dataForm.teamIcon = data.team.teamIcon
                this.dataForm.teamSupport = data.team.teamSupport
                this.dataForm.teamInfo = data.team.teamInfo
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
              url: this.$http.adornUrl(`/teams/team/${!this.dataForm.teamId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'teamId': this.dataForm.teamId || undefined,
                'teamName': this.dataForm.teamName,
                'teamIcon': this.dataForm.teamIcon,
                'teamSupport': this.dataForm.teamSupport,
                'teamInfo': this.dataForm.teamInfo
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
