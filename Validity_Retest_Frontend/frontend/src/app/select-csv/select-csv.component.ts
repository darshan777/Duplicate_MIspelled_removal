import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { CsvData } from "../model/CsvData";

@Component({
  selector: 'app-select-csv',
  templateUrl: './select-csv.component.html',
  styleUrls: ['./select-csv.component.css']
})
export class SelectCsvComponent implements OnInit {
  selectCsv: FormGroup;
  constructor(private router: Router) { }
  csvfile = new FormControl('normal');
  ngOnInit() {

  }
  onSubmit(){
    localStorage.setItem('currentFile', JSON.stringify(this.csvfile.value));
    this.router.navigate(['/selectData']);
    console.log(this.csvfile.value);
  }
}
