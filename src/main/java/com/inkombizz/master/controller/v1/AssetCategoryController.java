package com.inkombizz.master.controller.v1;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inkombizz.master.model.AssetCategory;
import com.inkombizz.master.model.dto.AssetCategoryDto;
import com.inkombizz.master.repository.AssetCategoryRepository;
import com.inkombizz.master.util.Response;

@RestController
@RequestMapping("v1/asset-category")
public class AssetCategoryController {
	@Autowired
	AssetCategoryRepository AssetCategoryDao;

	@GetMapping("/")
	public ResponseEntity<?> alldata(@RequestParam String search, String name) {
		try {
			if (search.isEmpty()) {
				List<AssetCategory> AssetCategorys = AssetCategoryDao.findAll();
				List<AssetCategoryDto> dtos = new ArrayList<>();

				for (AssetCategory m : AssetCategorys) {
					ModelMapper mapper = new ModelMapper();
					AssetCategoryDto dto = mapper.map(m, AssetCategoryDto.class);
					dtos.add(dto);
				}

				return new Response().response_json(true, "Ok", dtos, HttpStatus.OK);

			} else
				return new Response().response_json(true, "Ok",
						AssetCategoryDao.findByAssetCategoryCodeOrName(search, name), HttpStatus.OK);

		} catch (Exception ex)

		{
			return new Response().response_json(true, "Fail", null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{code}")
	public ResponseEntity<?> getByID(@PathVariable String code) {
		try {

			ModelMapper mapper = new ModelMapper();
			AssetCategory model = AssetCategoryDao.findById(code).get();
			AssetCategoryDto dto = mapper.map(model, AssetCategoryDto.class);

			return new Response().response_json(true, "Ok", dto, HttpStatus.OK);

		} catch (Exception ex) {
			return new Response().response_json(true, "Fail", null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/")
	public ResponseEntity<?> create(@Valid @RequestBody AssetCategory model) {
		try {

			AssetCategoryDao.save(model);
			return new Response().response_json(true, "Save Success", model, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new Response().response_json(true, "Save Fail", null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{code}")
	public ResponseEntity<?> update(@RequestBody AssetCategory model, @PathVariable String code) {
		try {
			AssetCategoryDao.save(model);
			return new Response().response_json(true, "Save Success", model, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new Response().response_json(true, "Save Fail", null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{code}")
	public ResponseEntity<?> delete(@PathVariable String code) {
		try {
			AssetCategoryDao.deleteById(code);
			return new Response().response_json(true, "Save Success", null, HttpStatus.OK);
		} catch (Exception ex) {
			return new Response().response_json(true, "Save Fail", null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
