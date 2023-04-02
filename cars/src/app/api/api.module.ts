/* tslint:disable */
/* eslint-disable */
import { NgModule, ModuleWithProviders, SkipSelf, Optional } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiConfiguration, ApiConfigurationParams } from './api-configuration';

import { Service } from './services/service';
import { USService } from './services/us-service';
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryUsers } from '../memory-us.service';
import { InMemoryDataService } from '../memory.service';
/**
 * Module that provides all services and configuration.
 */
@NgModule({
  imports: [
    InMemoryWebApiModule.forRoot(InMemoryDataService),

  ],
  exports: [],
  declarations: [],
  providers: [
    Service,
    Service,
    ApiConfiguration
  ],
})
export class ApiModule {
  static forRoot(params: ApiConfigurationParams): ModuleWithProviders<ApiModule> {
    return {
      ngModule: ApiModule,
      providers: [
        {
          provide: ApiConfiguration,
          useValue: params
        }
      ]
    }
  }

  constructor(
    @Optional() @SkipSelf() parentModule: ApiModule,
    @Optional() http: HttpClient
  ) {
    if (parentModule) {
      throw new Error('ApiModule is already loaded. Import in your base AppModule only.');
    }
    if (!http) {
      throw new Error('You need to import the HttpClientModule in your AppModule! \n' +
      'See also https://github.com/angular/angular/issues/20575');
    }
  }
}
