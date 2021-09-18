import Vue from 'vue'
import Router from 'vue-router'
import Team from "../components/Team"
import TeamMember from "../components/TeamMember"
import PersonalInformation from "../components/PersonalInformation";
import GameRecord from "../components/GameRecord";
import Video from "../components/Video";

Vue.use(Router)

const routes = [
  // {
  //   path: '',
  //   redirect: '/'
  // },
  {
    path: '/team/:teamname',
    name: 'Team',
    component: Team,
    meta: {
      title: '战队'
    }
  },
  {
    path: '/teammember/:membername',
    name: 'TeamMember',
    component: TeamMember,
    meta: {
      title: '队员'
    }
  },
  {
    path: '/personalinformation',
    name: 'PersonalInformation',
    component: PersonalInformation
  },
  {
    path: '/gamerecord',
    name: 'GameRecord',
    component: GameRecord
  },
  {
    path: '/video',
    name: 'Video',
    component: Video
  }
]

const router = new Router({
  routes,
  mode: "history"
})

export default router
