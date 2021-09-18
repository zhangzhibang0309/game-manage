<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="videoName">
      <el-input v-model="dataForm.videoName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="videoAddress">
      <el-input v-model="dataForm.videoAddress" placeholder=""></el-input>
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
          videoId: 0,
          videoName: '',
          videoAddress: ''
        },
        dataRule: {
          videoName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          videoAddress: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.videoId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.videoId) {
            this.$http({
              url: this.$http.adornUrl(`/teams/video/info/${this.dataForm.videoId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.videoName = data.video.videoName
                this.dataForm.videoAddress = data.video.videoAddress
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
              url: this.$http.adornUrl(`/teams/video/${!this.dataForm.videoId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'videoId': this.dataForm.videoId || undefined,
                'videoName': this.dataForm.videoName,
                'videoAddress': this.dataForm.videoAddress
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
