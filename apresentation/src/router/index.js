import Vue from 'vue';
import Router from 'vue-router';
import StoreFront from '@/container/storefront/index';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'storefront',
      component: StoreFront,
    },
  ],
});
