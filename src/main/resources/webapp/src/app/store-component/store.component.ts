import {Component, OnInit} from '@angular/core';
import {ProductModel} from '../model/product.model';
import {ComputerStoreService} from '../services/computer.store.service';
import {DeviceDetectorService} from 'ngx-device-detector';

@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.css']
})
export class StoreComponent implements OnInit {
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
    totalItems: 1303
  };

  constructor(private computerStoreService: ComputerStoreService,
              private deviceService: DeviceDetectorService) {
  }

  pageChanged(event) {
    this.config.currentPage = event;
    this.computerStoreService.loadStoreCatalog(this.config.currentPage, 5).then(data => this.productCatalog = data['computerModelList']);
  }

  ngOnInit(): void {
    this.notMobile = !this.deviceService.isMobile();
    this.computerStoreService.loadStoreCatalog(1, 5).then(data => this.productCatalog = data['computerModelList']);
  }
}
