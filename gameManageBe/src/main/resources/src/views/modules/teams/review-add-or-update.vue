<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="reviewOwner">
      <el-input v-model="dataForm.reviewOwner" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="reviewInfo">
      <el-input v-model="dataForm.reviewInfo" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="reviewParent">
      <el-input v-model="dataForm.reviewParent" placeholder=""></el-input>
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
          reviewId: 0,
          reviewOwner: '',
          reviewInfo: '',
          reviewParent: ''
        },
        dataRule: {
          reviewOwner: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          reviewInfo: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          reviewParent: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.reviewId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.reviewId) {
            this.$http({
              url: this.$http.adornUrl(`/teams/review/info/${this.dataForm.reviewId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.reviewOwner = data.review.reviewOwner
                this.dataForm.reviewInfo = data.review.reviewInfo
                this.dataForm.reviewParent = data.review.reviewParent
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
              url: this.$http.adornUrl(`/teams/review/${!this.dataForm.reviewId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'reviewId': this.dataForm.reviewId || undefined,
                'reviewOwner': this.dataForm.reviewOwner,
                'reviewInfo': this.dataForm.reviewInfo,
                'reviewParent': this.dataForm.reviewParent
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
