export class SearchCriteriaModel {
  private _os: string[];

  get os(): string[] {
    return this._os;
  }

  set os(value: string[]) {
    this._os = value;
  }

  private _ram: string[];

  get ram(): string[] {
    return this._ram;
  }

  set ram(value: string[]) {
    this._ram = value;
  }

  private _cpu: string[];

  get cpu(): string[] {
    return this._cpu;
  }

  set cpu(value: string[]) {
    this._cpu = value;
  }

  private _inches: string[];

  get inches(): string[] {
    return this._inches;
  }

  set inches(value: string[]) {
    this._inches = value;
  }
}
