package Lab3.ActionsWithCatalog;
import Lab3.Catalog;
import Lab3.ComparatorsForSortingCatalogByFields.*;
import Lab3.EnumsForSortingCatalogByFields.SortingCatalogByField;

import java.util.Collections;

public class SortingTheCatalogByField extends Catalog {

    public static void SortingByField( SortingCatalogByField option){
        switch(option){
            case NAME:{
                Collections.sort(catalog, new ComparatorByProductName());
            }break;
            case PRICE:{
                Collections.sort(catalog, new ComparatorByProductPrice());
            }break;
            case COMPANY_NAME:{
                Collections.sort(catalog, new ComparatorByProductCompanyName());
            }break;
            case AMOUNT:{
                Collections.sort(catalog, new ComparatorByAmountOfTheProduct());
            }break;

        }

    }

}
