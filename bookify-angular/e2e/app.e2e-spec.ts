import { BookifyAngularPage } from './app.po';

describe('bookify-angular App', () => {
  let page: BookifyAngularPage;

  beforeEach(() => {
    page = new BookifyAngularPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
