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
  csvData : CsvData[];
  constructor( private csvService : CsvServiceService) { }

  ngOnInit() {
    this.currentFile = JSON.parse(localStorage.getItem('currentFile'));
    console.log(this.currentFile);
  }
  noDuplicate(){
    this.csvService.getAllDataWithoutDuplicate().subscribe(
      (Response) =>{this.csvData = Response; console.log(this.csvData);}
    );

    this.dataList = true;
  }
  noMispell(){
    this.csvService.getAllDataWithoutDuplicateAndMispell().subscribe(
      (Response) =>{this.csvData = Response; console.log(this.csvData);}
    );
    this.dataList = false;
  }
}
