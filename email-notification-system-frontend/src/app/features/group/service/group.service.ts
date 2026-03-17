import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiServiceService } from '../../../core/services/api/api.service';
import { GroupResponse } from '../interfaces/group-response';

@Injectable({
  providedIn: 'root'
})
export class GroupService {

  defaultUrl: string = "/group";

  constructor(private apiService: ApiServiceService){}

  getAll() : Observable<GroupResponse>
  {
    return this.apiService.get<GroupResponse>(this.defaultUrl);
  }


}
