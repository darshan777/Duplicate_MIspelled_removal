import { Injectable } from '@angular/core';
import { Http, Response, Headers  } from '@angular/http';
import { CsvData } from "../model/CsvData";
import {catchError, map} from "rxjs/operators";
import { HttpClient } from "@angular/common/http";
import { Observable, of } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CsvServiceService {
  csvData:any =[];
  data : number;
  name : string;
  constructor(private http: HttpClient) { }
  private extractData(res: Response) {
    let body = res;
    return body || { };
  }

  getAllDataWithoutDuplicate(): Observable<any>{
     this.name = JSON.parse(localStorage.getItem('currentFile'));
    if(this.name === "normal"){
      this.data = 1;
    }
    else {
      this.data = 2;
    }
    console.log(this.name+":"+this.data);
    return this.http.get('http://localhost:8000/csv/noduplicate/'+ this.data ).pipe(
      map(this.extractData)
    );


  }

  getAllDataWithoutDuplicateAndMispell(): Observable<any>{
    this.name = JSON.parse(localStorage.getItem('currentFile'));
    if(this.name == "normal[1]"){
      this.data = 1;
    }
    else {
      this.data = 2;
    }
    console.log(this.name+":"+this.data);
    return this.http.get('http://localhost:8000/csv/nomispell/'+ this.data).pipe(
      map(this.extractData)
    );
  }
}
