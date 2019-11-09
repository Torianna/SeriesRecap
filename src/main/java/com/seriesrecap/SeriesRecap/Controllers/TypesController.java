package com.seriesrecap.SeriesRecap.Controllers;


import com.seriesrecap.SeriesRecap.Entites.Types;
import com.seriesrecap.SeriesRecap.Services.TypesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/seriesRecap/types")
@CrossOrigin
public class TypesController {
    final private TypesService typesService;

    @GetMapping("/{id}")
    public ResponseEntity<Types> getTypesById (@PathVariable Long id){

        Types types=typesService.getTypeById(id);

        return types != null ? new ResponseEntity<>(types, HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Types> deleteTypesById (@PathVariable Long id)
    {
        Types types=typesService.deleteTypeById(id);

        return types != null ? new ResponseEntity<>(types, HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Types> editTypesById (@PathVariable Long id, Types type)
    {
        Types editedType =typesService.editTypeById(id, type);

        return editedType != null ? new ResponseEntity<>(editedType, HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<Types> saveTypes(@PathVariable Types type)
    {
        Types savedType= typesService.saveType(type);

        return savedType != null ? new ResponseEntity<>(savedType, HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
