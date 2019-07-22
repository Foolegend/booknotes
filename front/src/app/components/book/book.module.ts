import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule, MatSidenavModule, MatIconModule, MatListModule, MatMenuModule } from '@angular/material';
import { Routes, RouterModule } from '@angular/router';
import { BookComponent } from './book.component';
import {FlexLayoutModule} from '@angular/flex-layout'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BookInfoService } from '../book-info.service';
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
    HttpModule
  ],
  providers:[BookInfoService],
  declarations: [BookComponent]
})
export class BookModule { }
