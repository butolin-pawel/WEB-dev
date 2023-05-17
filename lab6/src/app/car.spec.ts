import { Car } from './class/car';

describe('Car', () => {
  it('should create an instance', () => {
    expect(new Car()).toBeTruthy();
  });
});
