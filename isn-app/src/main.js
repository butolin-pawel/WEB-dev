// import Vue from 'vue'
// import App from './App.vue'
// import Vuetify from 'vuetify'
// import 'vuetify/dist/vuetify.min.css'
// Vue.config.productionTip = false
// Vue.use(Vuetify)
// new Vue({
//   render: h => h(App),
// }).$mount('#app')
import { createApp } from 'vue'
import App from './App.vue'
import 'vuetify/styles'
import { createVuetify } from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'

const vuetify = createVuetify({
    components,
    directives,
  })
  
createApp(App).use(vuetify).mount('#app')
