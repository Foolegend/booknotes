import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule, MatSidenavModule, MatIconModule, MatListModule, MatMenuModule, MatTabsModule } from '@angular/material';
import { Routes, RouterModule } from '@angular/router';
import { BookComponent } from './book.component';
import {FlexLayoutModule} from '@angular/flex-layout'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BookInfoService } from '../book-info.service';
import { NgCircleProgressModule } from 'ng-circle-progress';
const routes: Routes = [
  {path:'', component: BookComponent, 
    children:[
      // {path:'order', component: OrderComponent},
      // {path:'revoke',component: RevokeComponent}
    ]
  }
];
@NgModule({
  imports: [
    CommonModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    FlexLayoutModule,
    RouterModule.forChild(routes),
    FormsModule,
    ReactiveFormsModule,
    MatMenuModule,
    HttpModule,
    NgCircleProgressModule.forRoot({
      // set defaults here
      radius: 100,
      outerStrokeWidth: 10,
      innerStrokeWidth: 8,
      outerStrokeColor: "#78C000",
      innerStrokeColor: "#C7E596",
      animationDuration: 1000,
      animation:false,
      showUnits:true,
      title:"auto",
      maxPercent:100
    }),
    MatTabsModule,
  ],
  providers:[BookInfoService],
  declarations: [BookComponent]
})
export class BookModule { }
