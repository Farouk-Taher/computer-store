import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ComputerStoreService {

  constructor(private http: HttpClient) {
  }

  async loadStoreCatalog(page, size) {
    return await this.http.get(`http://127.0.0.1:8080/getProducts/${page}/${size}`).toPromise();
  }

  async loadSearchCriteria() {
    return await this.http.get(`http://127.0.0.1:8080/getSearchCriteria`).toPromise();
  }

  async search(searchQueryModel) {
    return await this.http.post(`http://127.0.0.1:8080/getSearchResult`, searchQueryModel).toPromise();
  }

}
