import { Component, OnInit } from '@angular/core';
import  { CsvData } from "../model/CsvData";
import { CsvServiceService } from "../service/csv-service.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-select-data',
  templateUrl: './select-data.component.html',
  styleUrls: ['./select-data.component.css']
})
export class SelectDataComponent implements OnInit {
  currentFile : String;
  csvDataList : any =[];


  constructor( private csvService : CsvServiceService, private router: Router) { }

  ngOnInit() {
    this.currentFile = JSON.parse(localStorage.getItem('currentFile'));
    console.log(this.currentFile);
  }
  noDuplicate(){
    this.csvService.getAllDataWithoutDuplicate().subscribe(
      (data : {}) => {this.csvDataList = data; console.log(this.csvDataList);}
    );

  }
  noMispell(){
    this.csvService.getAllDataWithoutDuplicateAndMispell().subscribe(
      (data : {}) => {this.csvDataList = data; console.log(this.csvDataList);}
    );
  }
  goBack(){
    this.router.navigate(['/']);
  }
}
