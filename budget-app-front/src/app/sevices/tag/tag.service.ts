import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of, Subject } from 'rxjs';
import { Tag } from 'src/app/models/Tag';

@Injectable({
  providedIn: 'root'
})
export class TagService {

  public allTagsResult: Observable<Tag[]>;
  public hostAdress: String = 'http://localhost:8081/'
  public subject = new Subject<HttpErrorResponse>();

  constructor(private http: HttpClient) { }

  onErrorOccurrs(): Observable<HttpErrorResponse> {
    return this.subject.asObservable();
  }


  public getAllTags(): Observable<Tag[]>{

    let url = this.hostAdress.concat('tags');
    this.allTagsResult = new Observable( observer => {
      this.http.get(url).subscribe( response => {
        
        let tagsFromResponse = response['tags'];
        observer.next(tagsFromResponse);

      }, err => this.handlerException(err));  
    });
    
    return this.allTagsResult;
  
  }

  public handlerException(err: HttpErrorResponse) {
    this.subject.next(err);
  }




}


