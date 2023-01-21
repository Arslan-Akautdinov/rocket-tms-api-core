package org.rocket.tms.api.core.controllers.base;

import org.rocket.tms.api.core.entities.base.EntityWithId;
import org.rocket.tms.api.core.services.base.BaseCrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public class CrudController<E extends EntityWithId, T extends BaseCrudService<E, ?>> {
    protected final T service;

    public CrudController(T service) {
        this.service = service;
    }

    @PostMapping("create")
    public ResponseEntity<E> create(
            @RequestBody E item
    ) {
        return service
                .create(item)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("select/{id}")
    public ResponseEntity<E> selectById(
            @PathVariable long id
    ) {
        return service
                .select(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<E> updateById(
            @PathVariable long id,
            @RequestBody E item
    ) {
        item.setId(id);
        return service
                .update(id, item)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteById(
            @PathVariable long id
    ) {
        return service.delete(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
}
