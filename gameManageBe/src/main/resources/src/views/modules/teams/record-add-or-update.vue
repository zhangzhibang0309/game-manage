<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="recordVideoid">
      <el-input v-model="dataForm.recordVideoid" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="recordWin">
      <el-input v-model="dataForm.recordWin" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="recordFail">
      <el-input v-model="dataForm.recordFail" placeholder=""></el-input>
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
          recordId: 0,
          recordVideoid: '',
          recordWin: '',
          recordFail: ''
        },
        dataRule: {
          recordVideoid: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          recordWin: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          recordFail: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.recordId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.recordId) {
            this.$http({
              url: this.$http.adornUrl(`/teams/record/info/${this.dataForm.recordId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.recordVideoid = data.record.recordVideoid
                this.dataForm.recordWin = data.record.recordWin
                this.dataForm.recordFail = data.record.recordFail
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
              url: this.$http.adornUrl(`/teams/record/${!this.dataForm.recordId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'recordId': this.dataForm.recordId || undefined,
                'recordVideoid': this.dataForm.recordVideoid,
                'recordWin': this.dataForm.recordWin,
                'recordFail': this.dataForm.recordFail
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
