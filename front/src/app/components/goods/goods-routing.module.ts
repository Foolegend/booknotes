import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { OrderComponent } from './order/order.component';
import { RevokeComponent } from './revoke/revoke.component';
import { MyNavComponent } from './my-nav/my-nav.component';

const routes: Routes = [
  {path:'', component: MyNavComponent, 
    children:[
      {path:'order', component: OrderComponent},
      {path:'revoke',component: RevokeComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GoodsRoutingModule { }
