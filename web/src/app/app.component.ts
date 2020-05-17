import {ChangeDetectorRef, Component, OnDestroy} from '@angular/core';
import {MediaMatcher} from '@angular/cdk/layout';
import {AuthService} from './service/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnDestroy {
  title = 'web';

  mobileQuery: MediaQueryList;

  private readonly mobileQueryListener: () => void;
  isAdmin = false;
  isLoggedIn = false;

  constructor(changeDetectorRef: ChangeDetectorRef, media: MediaMatcher,
              private authService: AuthService, private router: Router) {
    this.navigateToLogin();
    this.isAdmin = this.authService.IsAdmin();
    authService.userObservable$.subscribe((user) => {
      this.navigateToLogin();
      this.isAdmin = this.authService.IsAdmin();
    });
    this.mobileQuery = media.matchMedia('(max-width: 600px)');
    this.mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addListener(this.mobileQueryListener);
  }

  ngOnDestroy(): void {
    this.mobileQuery.removeListener(this.mobileQueryListener);
  }

  navigateToLogin() {
    this.isLoggedIn = this.authService.IsLoggedIn();
    if (!this.isLoggedIn) {
      this.router.navigate(['/login']);
    }
  }

  signOut() {
    this.authService.LogOut();
  }
}
