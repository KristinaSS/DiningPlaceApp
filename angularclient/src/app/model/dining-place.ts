/*export interface IDiningPlace {
  diningPlaceID: number;
  diningPlaceName: string;
  diningPlaceAddress: string;
  diningPlaceNumber: string;
  diningPlaceLinkToWebsite: string;
  diningPlaceFoodRating: number;
  diningPlaceValueRating: number;
  diningPlaceOverallRating: number;
}*/

export class DiningPlace{
 /* constructor(public diningPlaceID: number,
              public diningPlaceName: string,
              public diningPlaceAddress: string,
              public diningPlaceNumber: string,
              public diningPlaceLinkToWebsite: string,
              public diningPlaceFoodRating: number,
              public diningPlaceValueRating: number,
              public diningPlaceOverallRating: number) {
  }*/
  foodPlaceID: number;
  name: string;
  address: string;
  telephone: string;
  linkToWebsite: string;
  foodRating: number;
  valueRating: number;
  overallRating: number;
}
