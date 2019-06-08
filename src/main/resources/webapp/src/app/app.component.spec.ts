import {async, TestBed} from '@angular/core/testing';
import {AppComponent} from './app.component';

describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
    }).compileComponents();
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'webapp'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('webapp');
  });

  it('should render title in a h1 tag', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toContain('Welcome to webapp!');
  });

  // it('Should return all search criteria to build query', () => {
  //   let storeService: ComputerStoreService;
  //   const expected = {
  //     'ram': [
  //       '12GB',
  //       '16GB',
  //       '24GB',
  //       '2GB',
  //       '32GB',
  //       '4GB',
  //       '64GB',
  //       '6GB',
  //       '8GB'
  //     ]
  //   };
  //   let returnedValue;
  //   storeService.loadSearchCriteria().then(data => {
  //     returnedValue = data;
  //   });
  //   expect(returnedValue.ram).toEqual(expected.ram);
  // });
  //
  // it('Should return 1 item only in the product catalog', () => {
  //   let storeService: ComputerStoreService;
  //   const expected = {
  //     computerModelList: [
  //       {
  //         company: 'Apple',
  //         product: 'MacBook Pro',
  //         type: 'Ultrabook',
  //         inches: '13.3',
  //         resolution: 'IPS Panel Retina Display 2560x1600',
  //         cpu: 'Intel Core i5 2.3GHz',
  //         ram: '8GB',
  //         memory: '128GB SSD',
  //         graphics: 'Intel Iris Plus Graphics 640',
  //         os: 'macOS',
  //         weight: '1.37kg',
  //         price: '1339.69'
  //       }
  //     ]
  //   };
  //   let returnedValue: any;
  //   storeService.loadStoreCatalog(1, 1).then(data => returnedValue = data);
  //   expect(returnedValue).toEqual(expected);
  // });
});
