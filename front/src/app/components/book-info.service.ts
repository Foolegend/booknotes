import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class BookInfoService {

  constructor(private http: Http) { }

  getBookInfos(){
    return this.http.get("/api/getbookinfo");
  }
}
