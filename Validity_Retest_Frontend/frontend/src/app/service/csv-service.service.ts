import { Injectable } from '@angular/core';
import { Http, Response, Headers  } from '@angular/http';
import { CsvData } from "../model/CsvData";
import {catchError, map} from "rxjs/operators";
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CsvServiceService {
  csvData : CsvData[];
  constructor(private http: HttpClient) { }

  getAllDataWithoutDuplicate(){
    return this.http.get('http://localhost:8000/noduplicate' ).pipe(
      );

  }

  getAllDataWithoutDuplicateAndMispell(){
    return this.http.get('http://localhost:8000/nomispell' ).pipe(
    );
  }
}
