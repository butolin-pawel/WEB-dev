/* tslint:disable */
/* eslint-disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpContext } from '@angular/common/http';
import { BaseService } from '../../api/base-service';
import { ApiConfiguration } from '../../api/api-configuration';
import { StrictHttpResponse } from '../../api/strict-http-response';
import { RequestBuilder } from '../../api/request-builder';
import { Observable } from 'rxjs';
import { map, filter } from 'rxjs/operators';

import { User } from '../../api/models/user';
import { Users } from '../../api/models/users';


/**
 * Get
 */
@Injectable({
  providedIn: 'root',
})
export class USService extends BaseService {
  constructor(
    config: ApiConfiguration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Path part for operation getAllUsers
   */
  static readonly GetAllUsersPath = '/users';

  /**
   * Получить список.
   *
   * Get
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getAllUsers()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllUsers$Response(params?: {
  },
  context?: HttpContext

): Observable<StrictHttpResponse<Users>> {

    const rb = new RequestBuilder(this.rootUrl, USService.GetAllUsersPath, 'get');
    if (params) {
    }

    return this.http.request(rb.build({
      responseType: 'json',
      accept: 'application/json',
      context: context
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return r as StrictHttpResponse<Users>;
      })
    );
  }

  /**
   * Получить список.
   *
   * Get
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getAllUsers$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllUsers(params?: {
  },
  context?: HttpContext

): Observable<Users> {

    return this.getAllUsers$Response(params,context).pipe(
      map((r: StrictHttpResponse<Users>) => r.body as Users)
    );
  }

  /**
   * Path part for operation addUs
   */
  static readonly AddUsPath = '/users';

  /**
   * Создать.
   *
   * Post
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `addUs()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  addUs$Response(params: {
    body: User
  },
  context?: HttpContext

): Observable<StrictHttpResponse<User>> {

    const rb = new RequestBuilder(this.rootUrl, USService.AddUsPath, 'post');
    if (params) {
      rb.body(params.body, 'application/json');
    }

    return this.http.request(rb.build({
      responseType: 'json',
      accept: 'application/json',
      context: context
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return r as StrictHttpResponse<User>;
      })
    );
  }

  /**
   * Создать.
   *
   * Post
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `addUs$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  addUs(params: {
    body: User
  },
  context?: HttpContext

): Observable<User> {

    return this.addUs$Response(params,context).pipe(
      map((r: StrictHttpResponse<User>) => r.body as User)
    );
  }

  /**
   * Path part for operation getUser
   */
  static readonly GetUserPath = '/users/{login}';

  /**
   * Получить user.
   *
   * Get
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getUser()` instead.
   *
   * This method doesn't expect any request body.
   */
  getUser$Response(params: {
    login: string;
  },
  context?: HttpContext

): Observable<StrictHttpResponse<User>> {

    const rb = new RequestBuilder(this.rootUrl, USService.GetUserPath, 'get');
    if (params) {
      rb.path('login', params.login, {});
    }

    return this.http.request(rb.build({
      responseType: 'json',
      accept: 'application/json',
      context: context
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return r as StrictHttpResponse<User>;
      })
    );
  }

  /**
   * Получить user.
   *
   * Get
   *
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getUser$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getUser(params: {
    login: string;
  },
  context?: HttpContext

): Observable<User> {

    return this.getUser$Response(params,context).pipe(
      map((r: StrictHttpResponse<User>) => r.body as User)
    );
  }

}
