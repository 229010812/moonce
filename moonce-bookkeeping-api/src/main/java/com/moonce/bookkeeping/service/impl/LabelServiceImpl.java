package com.moonce.bookkeeping.service.impl;

import com.moonce.bookkeeping.entity.Label;
import com.moonce.bookkeeping.repository.LabelRepository;
import com.moonce.bookkeeping.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("labelService")
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelRepository labelRepository;
    @Override
    public void save(Label label) {
        labelRepository.save(label);
    }

    @Override
    public Label get(Integer id) {
        Optional<Label> o = labelRepository.findById(id);
        return o.get();
    }

    @Override
    public List<Label> list(Label label) {
        Example<Label> e = Example.of(label);
        Sort s = Sort.by(Sort.Direction.DESC,"ranking");
        return labelRepository.findAll(e,s);
    }

    @Override
    public Page<Label> page(Pageable pageable) {
        return labelRepository.findAll(pageable);
    }

    @Override
    public void delete(Integer id) {
        labelRepository.deleteById(id);
    }
}
