<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="teamRecordInfoMemberOne">
      <el-input v-model="dataForm.teamRecordInfoMemberOne" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="teamRecordInfoMemberTwo">
      <el-input v-model="dataForm.teamRecordInfoMemberTwo" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="teamRecordInfoHexoOne">
      <el-input v-model="dataForm.teamRecordInfoHexoOne" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="teamRecordInfoHexoTwo">
      <el-input v-model="dataForm.teamRecordInfoHexoTwo" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="teamRecordInfoParent">
      <el-input v-model="dataForm.teamRecordInfoParent" placeholder=""></el-input>
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
          teamRecordInfoId: 0,
          teamRecordInfoMemberOne: '',
          teamRecordInfoMemberTwo: '',
          teamRecordInfoHexoOne: '',
          teamRecordInfoHexoTwo: '',
          teamRecordInfoParent: ''
        },
        dataRule: {
          teamRecordInfoMemberOne: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          teamRecordInfoMemberTwo: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          teamRecordInfoHexoOne: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          teamRecordInfoHexoTwo: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          teamRecordInfoParent: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.teamRecordInfoId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.teamRecordInfoId) {
            this.$http({
              url: this.$http.adornUrl(`/teams/teamrecordinfo/info/${this.dataForm.teamRecordInfoId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.teamRecordInfoMemberOne = data.teamRecordInfo.teamRecordInfoMemberOne
                this.dataForm.teamRecordInfoMemberTwo = data.teamRecordInfo.teamRecordInfoMemberTwo
                this.dataForm.teamRecordInfoHexoOne = data.teamRecordInfo.teamRecordInfoHexoOne
                this.dataForm.teamRecordInfoHexoTwo = data.teamRecordInfo.teamRecordInfoHexoTwo
                this.dataForm.teamRecordInfoParent = data.teamRecordInfo.teamRecordInfoParent
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
              url: this.$http.adornUrl(`/teams/teamrecordinfo/${!this.dataForm.teamRecordInfoId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'teamRecordInfoId': this.dataForm.teamRecordInfoId || undefined,
                'teamRecordInfoMemberOne': this.dataForm.teamRecordInfoMemberOne,
                'teamRecordInfoMemberTwo': this.dataForm.teamRecordInfoMemberTwo,
                'teamRecordInfoHexoOne': this.dataForm.teamRecordInfoHexoOne,
                'teamRecordInfoHexoTwo': this.dataForm.teamRecordInfoHexoTwo,
                'teamRecordInfoParent': this.dataForm.teamRecordInfoParent
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
