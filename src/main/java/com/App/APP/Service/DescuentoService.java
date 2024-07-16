package com.App.APP.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.App.APP.DTO.DescuentoDTO;
import com.App.APP.Entity.Descuento;
import com.App.APP.Mapper.DescuentoMapper;
import com.App.APP.Repositorio.DescuentoRepository;

@Service
public class DescuentoService {
    @Autowired
    private DescuentoRepository descuentoRepository;

    public List<DescuentoDTO> SearchAllDescuento() {
        List<Descuento> descuentoList = descuentoRepository.findAll();
        if (descuentoList.isEmpty()) {
            return null;
        }
        return descuentoList.stream().map(DescuentoMapper::DatosToDTO).collect(Collectors.toList());
    }

    public void SaveDescuento(DescuentoDTO descuentoDTO) {
        Descuento Descuento = DescuentoMapper.DatosToEntity(descuentoDTO);
        descuentoRepository.save(Descuento);
    }

    public void editDescuento(int idDescuento, DescuentoDTO descuentoDTO) {
        Descuento descuentoEncontrado = searchEntityDescuento(idDescuento);
        descuentoEncontrado.setN_sesiones(descuentoDTO.getN_sesiones());
        descuentoEncontrado.setDescuento(descuentoDTO.getDescuento());

        descuentoRepository.save(descuentoEncontrado);
    }

    public void deleteDescuento(int idDescuento) {
        Descuento DescuentoEncontrado = searchEntityDescuento(idDescuento);
        descuentoRepository.delete(DescuentoEncontrado);
    }

    private Descuento searchEntityDescuento(int idDescuento) {
        return descuentoRepository.findById(idDescuento)
                .orElseThrow(() -> new RuntimeException("Descuento No encontrado con el id " + idDescuento));
    }
}
