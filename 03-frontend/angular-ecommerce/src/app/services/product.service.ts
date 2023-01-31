import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../common/product';
import { map } from 'rxjs/operators';

// our service can be injected into other classes / components
@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8080/api/products';
  // By default, Spring Data REST only returns 1st page of 20 items
  // localhost:8080/api/products?size=100 - this will change page size to 100 items

  // inject HttpClient into our service
  constructor(private httpClient: HttpClient) { }

  getProductList(theCategoryId: number): Observable<Product[]> {
    
    // @TODO: need to build URL based on category id ... will come back to this later!
    return this.httpClient.get<GetResponse>(this.baseUrl).pipe(
      map(response => response._embedded.products) //map the JSON data from Spring Data REST to Product array
    );
  }
}

//Unwraps the JSON from Spring Data REST _embedded entry
interface GetResponse {
  _embedded: {
    products: Product[]
  };
}
