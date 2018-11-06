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
  message : String;
  condition : String;


  constructor( private csvService : CsvServiceService, private router: Router) { }

  ngOnInit() {
    this.currentFile = JSON.parse(localStorage.getItem('currentFile'));
    console.log(this.currentFile);
  }
  noDuplicate(){
    this.csvService.getAllDataWithoutDuplicate().subscribe(
      (data : {}) => {this.csvDataList = data; console.log(this.csvDataList);}
    );
    this.message= "Contains No exact Duplicate ( Mispelled words are not considered exact duplicate).";
    this.condition = " first_name, email, phone have to be unique for not being as Exact Duplicates.";
  }
  noMispell(){
    this.csvService.getAllDataWithoutDuplicateAndMispell().subscribe(
      (data : {}) => {this.csvDataList = data; console.log(this.csvDataList);}
    );
    this.message= "Contains No exact Duplicate and Mispelled Words. Mispell of more than 2 letter is not considered mispell.";
    this.condition = "If first_name is mispelled, email and phone should be same to be considered as mispell. Similarly if email is mispelled first_name and phone should be same"+
                      "and for phone mispell, first_name and email has to be same";

  }
  duplicate(){
    this.csvService.getDuplicate().subscribe(
      (data : {}) => {this.csvDataList = data; console.log(this.csvDataList);}
    );
    this.message= "Contains No exact Duplicate ( Mispelled words are not considered exact duplicate).";
    this.condition = " first_name, email, phone have to be unique for not being as Exact Duplicates.";
  }

  mispell(){
    this.csvService.getMispelled().subscribe(
      (data : {}) => {this.csvDataList = data; console.log(this.csvDataList);}
    );
    this.message= "Contains No exact Duplicate ( Mispelled words are not considered exact duplicate).";
    this.condition = " first_name, email, phone have to be unique for not being as Exact Duplicates.";
  }
  goBack(){
    this.router.navigate(['/']);
  }
}
