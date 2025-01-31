//package com.webmusic.service.singer;
//
//import com.webmusic.model.Singer;
//import com.webmusic.repository.SingerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@Transactional
//public class SingerService implements ISingerService {
//    SingerRepository singerRepository;
//
//    @Autowired
//    public SingerService(SingerRepository singerRepository) {
//        this.singerRepository = singerRepository;
//    }
//
//    @Override
//    public Iterable<Singer> getAll() {
//        return singerRepository.findAll();
//    }
//
//    @Override
//    public Optional<Singer> findById(Long id) {
//        return singerRepository.findById(id);
//    }
//
//    @Override
//    public Singer save(Singer singer) {
//        return singerRepository.save(singer);
//    }
//
//    @Override
//    public void delete(Long id) {
//        singerRepository.deleteById(id);
//    }
//
//    @Override
//    public List<Singer> findByNameContains(String name) {
//        return singerRepository.findByNameContains(name);
//    }
//}
