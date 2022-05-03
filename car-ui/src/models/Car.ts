export interface Car {
  carId: number;
  brand: string;
  model: string;
  color: string;
  registerNumber: string;
  year: number;
  price: number;
}

export interface CarPayload {
  brand: string;
  model: string;
  color: string;
  year: string;
  price: string;
}
