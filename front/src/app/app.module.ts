import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {RouterModule, Routes } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpModule } from '@angular/http';
import { MatButtonModule, MatToolbarModule, MatIconModule, MatSidenavModule, MatListModule, MatMenuModule } from '@angular/material';
import { TopnavComponent } from './components/topnav/topnav.component';
import { CommonModule } from '@angular/common';
import { FlexLayoutModule } from '@angular/flex-layout';
import { SubmitComponent } from './components/submit/submit.component';
import { BookInfoService } from './components/book-info.service';

export const APPROUTES: Routes = [
  {path:'',redirectTo:'book', pathMatch:'full'},
  {path:'book', loadChildren: './components/book/book.module#BookModule'},
  {path: 'submit', component: SubmitComponent},
  {path:'goods', loadChildren:'./components/goods/goods.module#GoodsModule'}
]
@NgModule({
  declarations: [
    AppComponent,
    TopnavComponent,
    SubmitComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(APPROUTES),
    BrowserAnimationsModule,
    HttpModule,
    FlexLayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatMenuModule
   ],
  providers: [BookInfoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
