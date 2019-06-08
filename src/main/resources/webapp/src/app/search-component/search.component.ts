import {Component, OnInit} from '@angular/core';
import {ComputerStoreService} from '../services/computer.store.service';
import {SearchCriteriaModel} from '../model/search.criteria.model';
import {SearchQueryModel} from '../model/search.query.model';
import {ProductModel} from '../model/product.model';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  searchCriteriaModel: SearchCriteriaModel = new SearchCriteriaModel();
  searchQueryModel: SearchQueryModel = new SearchQueryModel();
  productCatalog: ProductModel[] = [];
  public maxSize: number = 7;
  public directionLinks: boolean = true;
  public autoHide: boolean = false;
  public responsive: boolean = true;
  public labels: any = {
    previousLabel: '<--',
    nextLabel: '-->',
    screenReaderPaginationLabel: 'Pagination',
    screenReaderPageLabel: 'page',
    screenReaderCurrentLabel: `You're on page`
  };
  notMobile = true;
  config = {
    itemsPerPage: 5,
    currentPage: 1,
    totalItems: this.productCatalog.length
  };

  constructor(private storeService: ComputerStoreService) {
  }

  ngOnInit() {
    this.storeService.loadSearchCriteria().then(data => {
      this.searchCriteriaModel.cpu = data['cpu'];
      this.searchCriteriaModel.ram = data['ram'];
      this.searchCriteriaModel.os = data['os'];
      this.searchCriteriaModel.inches = data['inches'];
    });
  }

  searchSelected() {
    if (this.searchQueryModel.company || this.searchQueryModel.cpu || this.searchQueryModel.inches
      || this.searchQueryModel.os || this.searchQueryModel.product || this.searchQueryModel.ram) {
      this.storeService.search(this.searchQueryModel).then(data => {
        this.productCatalog = data['computerModelList'];
      });
    } else {
      alert('Please Enter Your Search Query Before Pressing The Search Button');
    }
  }

  pageChanged(event) {
    this.config.currentPage = event;
  }
}
