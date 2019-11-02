import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule, MatSidenavModule, MatIconModule, MatListModule } from '@angular/material';
import { Routes, RouterModule } from '@angular/router';
import { BookNotesComponent } from './booknotes/booknotes.component';
import {FlexLayoutModule} from '@angular/flex-layout'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BookInfoService } from '../book-info.service';
import { BooktreeComponent } from './booktree/booktree.component';
const routes: Routes = [
  {path:'', component: BookNotesComponent, 
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
    HttpModule,
  ],
  providers:[BookInfoService],
  declarations: [BookNotesComponent, BooktreeComponent]
})
export class BookModule { }
