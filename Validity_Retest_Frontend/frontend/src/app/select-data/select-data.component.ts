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
    this.message= "Contains No exact Duplicate and No Mispelled Words. Mispell of more than 3 letter is not considered mispell.";
    this.condition = "Atleast 2 parameters should be exact out of 3. ";

  }
  duplicate(){
    this.csvService.getDuplicate().subscribe(
      (data : {}) => {this.csvDataList = data; console.log(this.csvDataList);}
    );
    this.message= "Contains List of duplicate pairs ";
    this.condition = "Checks for exact duplicate and if one parameter is empty checks for other parameters";
  }

  mispell(){
    this.csvService.getMispelled().subscribe(
      (data : {}) => {this.csvDataList = data; console.log(this.csvDataList);}
    );
    this.message= "Contails list of mispelled words from the csv selected.";
    this.condition = "the sepping should not have more than 3 mispelled letters from the original word";
  }
  goBack(){
    this.router.navigate(['/']);
  }
}
