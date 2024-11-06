package com.feas.api.controller;

import java.util.List;

import com.feas.domain.entity.lookups.*;
import com.feas.persistence.repository.GeneralFacilityRepository;
import com.feas.persistence.repository.lookup.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.feas.service.model.BaseResponse;

@RestController
@RequestMapping("/look-up")
public class LookUpsController {
	
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private EquipCategoryRepository equipCategoryRepository;
	@Autowired
	private EquipmentCodeRepository equipmentCodeRepository;
	@Autowired
	private EquipmentTypeRepository equipmentTypeRepository;
	@Autowired
	private ForeignCurrencyRepository foreignCurrencyRepository;
	@Autowired
	private MaterialRepository materialRepository;
	@Autowired
	private UnitRepository unitRepository;
	@Autowired
	private EquipmentPercentageRepository equipmentPercentageRepository;
	@Autowired
	private VehicalTypeRepository vehicalTypeRepository;
	@Autowired
	private ManufCtryRepository manufCtryRepository;
	@Autowired
	private BuildingRepository buildingRepository;

	@Autowired
	private StockTypeRepository stockTypeRepository;
	@Autowired
	private ProdOriginRepository prodOriginRepository;
	
	@Autowired
	private GeneralFacilityRepository generalFacilityRepository;
	@Autowired
	private ManpowerNationalityRepository manpowerNationalityRepository;

	@Autowired
	private ReportContentLookupRepository reportContentRepository;

	@Autowired
	private VehicalCodeRepository vehicalCodeRepository;

	@Autowired
	private ManpowerRepository manpowerRepository;

	@Autowired
	private ManpowerTypeRepository manpowerTypeRepository;

	@Autowired
	private ManpowerCatRepository manpowerCatRepository;

	@GetMapping(value = "/country")
	@ResponseBody
	public BaseResponse<List<Country>> getAllCountry() {
		List<Country> countryLst= countryRepository.findAll();
       return new BaseResponse<List<Country>>(countryLst,HttpStatus.OK.toString()); 
	
	}
	
	@GetMapping(value = "/product")
	@ResponseBody
	public BaseResponse<List<Product>> getAllProduct() {
		List<Product> productLst= productRepository.findAll();
       return new BaseResponse<List<Product>>(productLst,HttpStatus.OK.toString()); 
	
	}
	@GetMapping(value = "/equip-category")
	@ResponseBody
	public BaseResponse<List<EquipCategory>> getAllEquipCategory() {
		List<EquipCategory> equipCategoryLst= equipCategoryRepository.findAll();
       return new BaseResponse<List<EquipCategory>>(equipCategoryLst,HttpStatus.OK.toString()); 
	
	}
	
	@GetMapping(value = "/equipment-code")
	@ResponseBody
	public BaseResponse<List<EquipmentCode>> getAllEquipmentCode() {
		List<EquipmentCode> equipmentCodeLst= equipmentCodeRepository.findAll();
       return new BaseResponse<List<EquipmentCode>>(equipmentCodeLst,HttpStatus.OK.toString()); 
	
	}
	
	
	@GetMapping(value = "/equipment-type")
	@ResponseBody
	public BaseResponse<List<EquipmentType>> getAllEquipmentType() {
		List<EquipmentType> equipmentCodeLst= equipmentTypeRepository.findAll();
       return new BaseResponse<List<EquipmentType>>(equipmentCodeLst,HttpStatus.OK.toString()); 
	
	}
	
	
	@GetMapping(value = "/foreign-currency")
	@ResponseBody
	public BaseResponse<List<ForeignCurrency>> getAllForeignCurrency() {
		List<ForeignCurrency> equipmentCodeLst= foreignCurrencyRepository.findAll();
       return new BaseResponse<List<ForeignCurrency>>(equipmentCodeLst,HttpStatus.OK.toString()); 
	
	}

	@GetMapping(value = "/material")
	@ResponseBody
	public BaseResponse<List<Material>> getAllMaterial() {
		List<Material> equipmentCodeLst= materialRepository.findAll();
		return new BaseResponse<List<Material>>(equipmentCodeLst,HttpStatus.OK.toString());

	}
	@GetMapping(value = "/unit")
	@ResponseBody
	public BaseResponse<List<Unit>> getAllUnit() {
		List<Unit> equipmentCodeLst= unitRepository.findAll();
		return new BaseResponse<List<Unit>>(equipmentCodeLst,HttpStatus.OK.toString());

	}
	@GetMapping(value = "/equipment-percentage")
	@ResponseBody
	public BaseResponse<List<EquipmentPercentage>> getAllEquipmentPercentage() {
		List<EquipmentPercentage> equipmentPercentagesLst= equipmentPercentageRepository.findAll();
		return new BaseResponse<List<EquipmentPercentage>>(equipmentPercentagesLst,HttpStatus.OK.toString());

	}


	@GetMapping(value = "/vehical-type")
	@ResponseBody
	public BaseResponse<List<VehicalType>> getAllVehicalType() {
		List<VehicalType> vehicalTypes= vehicalTypeRepository.findAll();
		return new BaseResponse<List<VehicalType>>(vehicalTypes,HttpStatus.OK.toString());

	}
	@GetMapping(value = "/manuf-ctry")
	@ResponseBody
	public BaseResponse<List<ManufCtry>> getAllManufCtry() {
		List<ManufCtry> manufCtries= manufCtryRepository.findAll();
		return new BaseResponse<List<ManufCtry>>(manufCtries,HttpStatus.OK.toString());

	}
	@GetMapping(value = "/building")
	@ResponseBody
	public BaseResponse<List<Building>> getAllBuilding() {
		List<Building> buildings= buildingRepository.findAll();
		return new BaseResponse<List<Building>>(buildings,HttpStatus.OK.toString());
	}

	@GetMapping(value = "/stockTypes")
	@ResponseBody
	public BaseResponse<List<StockType>> getAllStockType() {
		List<StockType> stockTypes= stockTypeRepository.findAll();
		return new BaseResponse<List<StockType>>(stockTypes,HttpStatus.OK.toString());
	}
	@GetMapping(value = "/prodOrigins")
	@ResponseBody
	public BaseResponse<List<ProdOrigin>> getAllProdOrigin() {
		List<ProdOrigin> prodOrigins= prodOriginRepository.findAll();
		return new BaseResponse<List<ProdOrigin>>(prodOrigins,HttpStatus.OK.toString());
	}
	@GetMapping(value = "/general-facility")
	@ResponseBody
	public BaseResponse<List<GeneralFacility>> getAllGeneralFacility() {
		List<GeneralFacility> generalFacilities= generalFacilityRepository.findAll();
		return new BaseResponse<>(generalFacilities,HttpStatus.OK.toString());
	}

	@GetMapping(value = "/manpower-nationality")
	@ResponseBody
	public BaseResponse<List<ManpowerNationality>> getAllManPowerNationality() {
		List<ManpowerNationality> manpowerNationalities= manpowerNationalityRepository.findAll();
		return new BaseResponse<>(manpowerNationalities,HttpStatus.OK.toString());
	}
	@GetMapping(value = "/ReportContent")
	@ResponseBody
	public BaseResponse<List<ReportContentDefault>> getAllReportTitle() {
		List<ReportContentDefault> reportTitleRepositoryAll= reportContentRepository.findAll();
		return new BaseResponse<List<ReportContentDefault>>(reportTitleRepositoryAll,HttpStatus.OK.toString());

	}

	@GetMapping(value = "/activeProducts")
	@ResponseBody
	public BaseResponse<List<Product>> getAllActiveProducts() {
		List<Product> productLst= productRepository.findByOperationIsNullOrOperationNot("D");
		return new BaseResponse<List<Product>>(productLst,HttpStatus.OK.toString());

	}

	@GetMapping(value = "/activeVehicleCodes")
	@ResponseBody
	public BaseResponse<List<VehicalCode>> getAllActiveVehicleCode() {
		List<VehicalCode> vehicleCodeLst= vehicalCodeRepository.findByOperationIsNullOrOperationNot("D");
		return new BaseResponse<List<VehicalCode>>(vehicleCodeLst,HttpStatus.OK.toString());

	}

	@GetMapping(value = "/activeManpower")
	@ResponseBody
	public BaseResponse<List<Manpower>> getActiveManpower() {
		List<Manpower> manpowerList= manpowerRepository.findByOperationIsNullOrOperationNot("D");
		return new BaseResponse<List<Manpower>>(manpowerList,HttpStatus.OK.toString());

	}
//
	@GetMapping(value = "/activeManpowerType")
	@ResponseBody
	public BaseResponse<List<ManpowerType>> getActiveManpowerType() {
		List<ManpowerType> manpowerTypeList= manpowerTypeRepository.findByOperationNot("D");
		return new BaseResponse<List<ManpowerType>>(manpowerTypeList,HttpStatus.OK.toString());

	}

	@GetMapping(value = "/activeManpowerCat")
	@ResponseBody
	public BaseResponse<List<ManpowerCat>> getActiveManpowerCat() {
		List<ManpowerCat> manpowerCatList= manpowerCatRepository.findByOperationIsNullOrOperationNot("D");
		return new BaseResponse<List<ManpowerCat>>(manpowerCatList,HttpStatus.OK.toString());

	}

	@GetMapping(value = "/activeMaterials")
	@ResponseBody
	public BaseResponse<List<Material>> getActiveMaterial() {
		List<Material> materialList= materialRepository.findByOperationIsNullOrOperationNot("D");
		return new BaseResponse<List<Material>>(materialList,HttpStatus.OK.toString());

	}

	@GetMapping(value = "/activeEquipmentCode")
	@ResponseBody
	public BaseResponse<List<EquipmentCode>> getActiveEquipmentCode() {
		List<EquipmentCode> equipmentCodeLst= equipmentCodeRepository.findByOperationIsNullOrOperationNot("D");
		return new BaseResponse<List<EquipmentCode>>(equipmentCodeLst,HttpStatus.OK.toString());

	}

}
