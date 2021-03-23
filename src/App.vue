<template>
  <div id="app">
    <el-menu router :default-active="$router.path" class="el-menu-demo" mode="horizontal" @select="handleSelect">
      <el-submenu index="team">
        <template slot="title">战队信息</template>
        <el-menu-item :index="'/team/' + teamname[0]">战队1</el-menu-item>
        <el-menu-item :index="'/team/' + teamname[1]">战队2</el-menu-item>
        <el-menu-item :index="'/team/' + teamname[2]">战队3</el-menu-item>
        <el-menu-item :index="'/team/' + teamname[3]">战队4</el-menu-item>
      </el-submenu>
      <el-submenu index="teammember">
        <template slot="title">战队成员</template>
        <el-submenu index="2-1">
          <template slot="title">队伍1</template>
          <el-menu-item :index="'/teammember/' + membername[0]">成员1</el-menu-item>
          <el-menu-item :index="'/teammember/' + membername[1]">成员2</el-menu-item>
          <el-menu-item :index="'/teammember/' + membername[2]">成员3</el-menu-item>
        </el-submenu>
        <el-submenu index="2-2">
          <template slot="title">队伍2</template>
          <el-menu-item :index="'/teammember/' + membername[3]">成员4</el-menu-item>
          <el-menu-item :index="'/teammember/' + membername[4]">成员5</el-menu-item>
          <el-menu-item :index="'/teammember/' + membername[5]">成员6</el-menu-item>
        </el-submenu>
        <el-submenu index="2-3">
          <template slot="title">队伍3</template>
          <el-menu-item :index="'/teammember/' + membername[6]">成员7</el-menu-item>
          <el-menu-item :index="'/teammember/' + membername[7]">成员8</el-menu-item>
          <el-menu-item :index="'/teammember/' + membername[8]">成员9</el-menu-item>
        </el-submenu>
      </el-submenu>
      <el-menu-item index="/gamerecord">对局记录</el-menu-item>
      <el-menu-item index="/video">战斗录像</el-menu-item>
      <el-menu-item index="/personalinformation">个人信息</el-menu-item>
    </el-menu>
    <div class="line"></div>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      activeIndex: '1',
      teamname: [
        'team1',
        'team2',
        'team3',
        'team4'
      ],
      membername: [
        'people1',
        'people2',
        'people3',
        'people4',
        'people5',
        'people6',
        'people7',
        'people8',
        'people9',
      ],
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
  }
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
}
</style>
