<template>
  <div>
    <h1>{{ TeamName }}</h1>
    <!--  队伍标志大图  -->
    <el-row>
      <el-col :span="24">
        <div class="grid-content-banner bg-img">
          <div class="team-bg-content">
            <el-row>
              <el-col :span="12">
                <div class="grid-content-banner-img bg-purple">
                  <div class="team-bg-content-img-box">
                    <img class="team-bg-content-img" src="../assets/img/teamMark.png" alt="">
                  </div>
                </div>
              </el-col>
              <el-col :span="12">
                <div class="grid-content-banner-text bg-purple-light">
                  <div class="team-bg-content-text-box">
                    <h1>team</h1>
                    <h3>team descripe</h3>
                    <br>
                    <span>nbps;战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述战队队描述战队描述战队描述战队描述战队描述战队描述战队描述战队描述</span>
                  </div>
                </div>
              </el-col>
            </el-row>
          </div>
        </div>
      </el-col>
    </el-row>
    <!--  人员介绍  -->
    <div class="member-box">
      <el-row>
        <el-col :span="4" offset="1">
          <div class="grid-content-member-img-box bg-purple">
            <div class="member-img-box">
              <img class="member-img" src="../assets/img/member.png" alt="">
              <p>
                队员介绍
              </p>
            </div>
          </div>
        </el-col>
        <el-col :span="4" offset="2">
          <div class="grid-content-member-img-box bg-purple">
            <img class="member-img" src="../assets/img/member.png" alt="">
            <p>
              队员介绍
            </p>
          </div>
        </el-col>
        <el-col :span="4" offset="2">
          <div class="grid-content-member-img-box bg-purple">
            <img class="member-img" src="../assets/img/member.png" alt="">
            <p>
              队员介绍
            </p>
          </div>
        </el-col>
        <el-col :span="4" offset="2">
          <div class="grid-content-member-img-box bg-purple">
            <img class="member-img" src="../assets/img/member.png" alt="">
            <p>
              队员介绍
            </p>
          </div>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="4" offset="1">
          <div class="grid-content-member-img-box bg-purple">
            <div class="member-img-box">
              <img class="member-img" src="../assets/img/member.png" alt="">
              <p>
                队员介绍
              </p>
            </div>
          </div>
        </el-col>
        <el-col :span="4" offset="2">
          <div class="grid-content-member-img-box bg-purple">
            <img class="member-img" src="../assets/img/member.png" alt="">
            <p>
              队员介绍
            </p>
          </div>
        </el-col>
        <el-col :span="4" offset="2">
          <div class="grid-content-member-img-box bg-purple">
            <img class="member-img" src="../assets/img/member.png" alt="">
            <p>
              队员介绍
            </p>
          </div>
        </el-col>
        <el-col :span="4" offset="2">
          <div class="grid-content-member-img-box bg-purple">
            <img class="member-img" src="../assets/img/member.png" alt="">
            <p>
              队员介绍
            </p>
          </div>
        </el-col>
      </el-row>
    </div>
    <!--  最近比赛  -->
    <el-table
      :data="tableData"
      stripe
      style="width: 80%">
      <el-table-column
        prop="date"
        label="日期"
        width="180">
      </el-table-column>
      <el-table-column
        prop="name"
        label="姓名"
        width="180">
      </el-table-column>
      <el-table-column
        prop="address"
        label="地址">
      </el-table-column>
      <el-table-column
        prop="address"
        label="地址">
      </el-table-column>
      <el-table-column
        prop="address"
        label="地址">
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "team",
  data() {
    return {
      tableData: [{
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '2016-05-04',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1517 弄'
      }, {
        date: '2016-05-01',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1519 弄'
      }, {
        date: '2016-05-03',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1516 弄'
      }]
    }
  },
  computed: {
    TeamName() {
      return this.$route.params.teamname
    }
  }
}
</script>

<style lang="scss" scoped>
.el-row {
  margin-bottom: 20px;

  &:last-child {
    margin-bottom: 0;
  }
}

.el-col {
  border-radius: 4px;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.grid-content-banner {
  border-radius: 4px;
  height: 521px;
}

.grid-content-banner-img {
  width: 100%;
  height: 521px;
  margin: 0 auto;
}

.team-bg-content-img-box {
  width: 70%;
  height: 70%;
  padding: 12%;
  margin: 0 auto;
}

.team-bg-content-img {
  width: 100%;
  height: 100%;
}

.grid-content-banner-text {
}

.bg-img {
  background-image: url("../assets/img/team_banner-bg.jpg");
}

.team-bg-content {
  width: 70%;
  height: 100%;
  margin: 0 auto;
  color: white;
}


.team-bg-content-text-box {
  width: 80%;
  height: 70%;
  margin: 22% auto;
}

span {
  color: white;
}

.bg-purple {
  background-color: #d3dce6;
}

.bg-purple-light {
  //border: 1px solid #d3dce6;
}

.bg-purple-dark {
  background: #99a9bf;
}

.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}

.image {
  width: 100%;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}

.grid-content-member-img-box {
  height: 300px;
  background-color: red;
}

.member-img-box {
  height: 100%;
}

.member-img {
  width: 100%;
}
</style>
