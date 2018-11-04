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
  Csv : CsvData;
  constructor(private http: HttpClient) { }
  private extractData(res: Response) {
    let body = res;
    return body || { };
  }

  getAllDataWithoutDuplicate(): Observable<any>{
    return this.http.get('http://localhost:8000/noduplicate' ).pipe(
      map(this.extractData)
    );


  }

  getAllDataWithoutDuplicateAndMispell(): Observable<any>{
    return this.http.get('http://localhost:8000/nomispell' ).pipe(
      map(this.extractData)
    );
  }
}
