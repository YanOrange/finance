package com.delay.finance.service.impl;

import com.delay.finance.entity.Project;
import com.delay.finance.repository.ProjectRepository;
import com.delay.finance.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 闫金柱
 * @create 2020-11-19 14:28
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public List<Project> findByUserId(Integer userId) {
        return projectRepository.findByUserId(userId);
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> getAllByStatus(int i) {
        return projectRepository.findAllByStatus(i);
    }

    @Override
    public Project findById(Integer projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    @Override
    public void saveOrUpdate(Project project) {
        projectRepository.saveAndFlush(project);
    }

    @Override
    public void deleteById(Integer projectId) {
        projectRepository.deleteById(projectId);
    }
}
