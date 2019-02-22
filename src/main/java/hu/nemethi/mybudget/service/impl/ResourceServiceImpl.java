package hu.nemethi.mybudget.service.impl;

import hu.nemethi.mybudget.dto.ResourcesDto;
import hu.nemethi.mybudget.entity.Resources;
import hu.nemethi.mybudget.mapping.ResourcesMapper;
import hu.nemethi.mybudget.repository.ResourcesRepository;
import hu.nemethi.mybudget.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService<ResourcesDto> {

    private ResourcesRepository resourcesRepository;
    private ResourcesMapper resourcesMapper;

    @Autowired
    private ParameterEncryptorServiceImpl parameterEncryptorService;

    public ResourceServiceImpl(ResourcesRepository resourcesRepository, ResourcesMapper resourcesMapper) {
        this.resourcesRepository = resourcesRepository;
        this.resourcesMapper = resourcesMapper;
    }

    @Override
    public ResourcesDto create(ResourcesDto resourcesDto) {
        return resourcesMapper.mapEntityToDto(resourcesRepository.save(resourcesMapper.mapDtoToEntity(resourcesDto)));
    }

    /**
     *
     * @param id is parameter encrypted
     * @return
     */
    @Override
    public void delete(String id) {
        resourcesRepository.deleteById(parameterEncryptorService.decrypt(id));
    }

    @Override
    public ResourcesDto modify(ResourcesDto resourcesDto) {
        return this.create(resourcesDto);
    }

    @Override
    public List<ResourcesDto> listAll() throws SQLException {
        List<ResourcesDto> resourcesDtos = new ArrayList<>();
        List<Resources> resources = resourcesRepository.findAll();
        resources.forEach( resources1 ->  {
            resourcesDtos.add(resourcesMapper.mapEntityToDto(resources1));
        });

        return resourcesDtos;
    }


}
