export class ProductModel {
  private _company: string;

  get company(): string {
    return this._company;
  }

  set company(value: string) {
    this._company = value;
  }

  private _product: string;

  get product(): string {
    return this._product;
  }

  set product(value: string) {
    this._product = value;
  }

  private _type: string;

  get type(): string {
    return this._type;
  }

  set type(value: string) {
    this._type = value;
  }

  private _inches: number;

  get inches(): number {
    return this._inches;
  }

  set inches(value: number) {
    this._inches = value;
  }

  private _resolution: string;

  get resolution(): string {
    return this._resolution;
  }

  set resolution(value: string) {
    this._resolution = value;
  }

  private _cpu: string;

  get cpu(): string {
    return this._cpu;
  }

  set cpu(value: string) {
    this._cpu = value;
  }

  private _ram: string;

  get ram(): string {
    return this._ram;
  }

  set ram(value: string) {
    this._ram = value;
  }

  private _memory: string;

  get memory(): string {
    return this._memory;
  }

  set memory(value: string) {
    this._memory = value;
  }

  private _graphics: string;

  get graphics(): string {
    return this._graphics;
  }

  set graphics(value: string) {
    this._graphics = value;
  }

  private _os: string;

  get os(): string {
    return this._os;
  }

  set os(value: string) {
    this._os = value;
  }

  private _weight: string;

  get weight(): string {
    return this._weight;
  }

  set weight(value: string) {
    this._weight = value;
  }

  private _price: number;

  get price(): number {
    return this._price;
  }

  set price(value: number) {
    this._price = value;
  }
}
