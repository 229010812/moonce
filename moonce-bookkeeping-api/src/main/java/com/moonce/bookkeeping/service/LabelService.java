package com.moonce.bookkeeping.service;

import com.moonce.bookkeeping.entity.Label;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LabelService {
    void save(Label label);

    Label get(Integer id);

    List<Label> list(Label label);

    Page<Label> page(Pageable pageable);

    void delete(Integer id);
}
