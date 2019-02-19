import Vue from 'vue';
import Router from 'vue-router';

import PriceList from '../components/price_list.vue';
import Calculator from '../components/calculator.vue';


Vue.use(Router);

export default new Router({
  routes: [{
    path: '/',
    name: 'PriceList',
    component: PriceList,
  },
  {
    path: '/calculator',
    name: 'Calculator',
    component: Calculator,
  },
  ],
});
