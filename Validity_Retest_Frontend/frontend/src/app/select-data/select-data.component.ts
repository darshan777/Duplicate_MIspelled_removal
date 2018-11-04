import { Component, OnInit } from '@angular/core';
import  { CsvData } from "../model/CsvData";
import { CsvServiceService } from "../service/csv-service.service";

@Component({
  selector: 'app-select-data',
  templateUrl: './select-data.component.html',
  styleUrls: ['./select-data.component.css']
})
export class SelectDataComponent implements OnInit {
  currentFile = String;
  dataList: boolean;
  csvDataList : any =[];
  csvData : CsvData;
  constructor( private csvService : CsvServiceService) { }

  ngOnInit() {
    this.currentFile = JSON.parse(localStorage.getItem('currentFile'));
    console.log(this.currentFile);
  }
  noDuplicate(){
    this.csvService.getAllDataWithoutDuplicate().subscribe(
      (data : {}) => {this.csvDataList = data; console.log(this.csvDataList);}
    );

    this.dataList = true;
  }
  noMispell(){
    this.csvService.getAllDataWithoutDuplicateAndMispell().subscribe(
      (data : {}) => {this.csvDataList = data; console.log(this.csvDataList);}
    );
    this.dataList = false;
  }
}
