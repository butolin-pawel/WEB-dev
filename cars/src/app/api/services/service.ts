/* tslint:disable */
/* eslint-disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpContext } from '@angular/common/http';
import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';
import { RequestBuilder } from '../request-builder';
import { Observable } from 'rxjs';
import { map, filter } from 'rxjs/operators';

import { Cars } from '../models/cars';


/**
 * Get
 */
@Injectable({
  providedIn: 'root',
})
export class Service extends BaseService {
  constructor(
    config: ApiConfiguration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Path part for operation getAllCar
   */
  static readonly GetAllCarPath = '/cars';

  /**
   * Получить список.
   *
   * Get
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getAllCar()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllCar$Response(params?: {
  },
  context?: HttpContext

): Observable<StrictHttpResponse<Cars>> {

    const rb = new RequestBuilder(this.rootUrl, Service.GetAllCarPath, 'get');
    if (params) {
    }

    return this.http.request(rb.build({
      responseType: 'json',
      accept: 'application/json',
      context: context
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return r as StrictHttpResponse<Cars>;
      })
    );
  }

  /**
   * Получить список.
   *
   * Get
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getAllCar$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllCar(params?: {
  },
  context?: HttpContext

): Observable<Cars> {

    return this.getAllCar$Response(params,context).pipe(
      map((r: StrictHttpResponse<Cars>) => r.body as Cars)
    );
  }

}
